import { Injectable } from '@angular/core';
import { AuthenticateUserInterface } from '../interfaces/authenticate-user.interface';
import { of, Observable, from } from 'rxjs';
import { first, map, tap } from 'rxjs/operators';
import { User } from '../interfaces/user.interface';
import { LocalStorageService } from './local-storage.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;
  constructor(
    private localStorageService: LocalStorageService,
    private http: HttpClient) {
    if (this.localStorageService.userExists()) {this.isLoggedIn = true; }
  }

  /**
   *
   * @param login User credentials (username, password)
   */
  public auth(login: AuthenticateUserInterface): Observable<User> {
    return this.http.post(
      'http://localhost:8080'
       + environment.apiPrefix
       + environment.apiVersion
       + '/login', login, {responseType: 'text'})
      .pipe(
        map((accessToken: string) => {
          return {username: login.username, token: accessToken};
        }),
        tap(user => this.localStorageService.setUser(user)),
        tap(_ => this.isLoggedIn = true)
      );
  }
}
