import { CanActivate, Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthenticatedGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const loggedIn = localStorage.getItem('loggedIn');
    if (!!loggedIn) {
      return loggedIn === 'true';
    }
    this.router.navigate(['auth']);
    return false;
  }
}
