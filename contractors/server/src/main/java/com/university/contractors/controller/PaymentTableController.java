package com.university.contractors.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.university.contractors.config.Endpoints;
import com.university.contractors.controller.dto.PaymentRecordDto;
import com.university.contractors.model.PaymentCurrent;
import com.university.contractors.repository.ContractRepository;
import com.university.contractors.repository.PaymentCurrentRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentTableController {

    private static final String DEFAULT_LOCALE_KEY = "en_US";

    private static final Map<String, Locale> SUPPORTED_LOCALES = ImmutableMap.<String, Locale>builder()
            .put(DEFAULT_LOCALE_KEY, new Locale("en", "US"))
            .put("uk_UA", new Locale("uk", "UA"))
            .put("ru_RU", new Locale("ru", "RU"))
            .build();
    private static final String MONTH_NAME_DATE_FORMAT_PATTERN = "MMMM";

    private final PaymentCurrentRepository paymentTableRepository;
    private final ContractRepository contractRepository;

    @Autowired
    public PaymentTableController(PaymentCurrentRepository paymentTableRepository,
                                  ContractRepository contractRepository) {
        this.paymentTableRepository = paymentTableRepository;
        this.contractRepository = contractRepository;
    }

    @GetMapping(path = Endpoints.PAYMENT_TABLE, params = {"contract_id"})
    public Iterable<PaymentRecordDto> get(@RequestParam(name = "contract_id") Long contractId,
                                          @RequestParam(name = "locale", defaultValue = DEFAULT_LOCALE_KEY) String localeKey) {

        if (!SUPPORTED_LOCALES.keySet().contains(localeKey)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Locale '%s' is not supported. Supported locales are: %s",
                            localeKey, Joiner.on(", ").join(SUPPORTED_LOCALES.keySet())));
        }

        if (!contractRepository.existsById(contractId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Contract with ID '%s' was not found", contractId));
        }

        final Iterable<PaymentCurrent> paymentCurrentIterable = paymentTableRepository.getByContractIdOrderByPayDate(contractId);
        final Map<Date, List<PaymentCurrent>> paymentCurrentGroupByPayDate = StreamSupport.stream(paymentCurrentIterable.spliterator(), Boolean.FALSE)
                .collect(Collectors.groupingBy(this::getDateRoundedToMonth));

        final Locale locale = SUPPORTED_LOCALES.get(localeKey);
        return paymentCurrentGroupByPayDate.entrySet()
                .stream()
                .map((Map.Entry<Date, List<PaymentCurrent>> dateListEntry) -> mapToPaymentRecordDto(dateListEntry, locale))
                .collect(Collectors.toList());
    }

    private Date getDateRoundedToMonth(PaymentCurrent paymentCurrent) {
        return DateUtils.round(paymentCurrent.getPayDate(), Calendar.MONTH);
    }

    private PaymentRecordDto mapToPaymentRecordDto(Map.Entry<Date, List<PaymentCurrent>> dateListEntry, Locale locale) {
        final Date dateToFormat = dateListEntry.getKey();

        final DateFormat dateFormat = new SimpleDateFormat(MONTH_NAME_DATE_FORMAT_PATTERN, locale);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateToFormat);

        final String monthName = dateFormat.format(dateToFormat);
        final int year = calendar.get(Calendar.YEAR);

        final PaymentRecordDto paymentRecordDto = new PaymentRecordDto();

        paymentRecordDto.setMonthName(monthName);
        paymentRecordDto.setYear(year);

        paymentRecordDto.setPaymentsList(dateListEntry.getValue());
        return paymentRecordDto;
    }
}
