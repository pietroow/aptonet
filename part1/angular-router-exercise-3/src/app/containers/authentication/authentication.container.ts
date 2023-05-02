import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'authentication',
  template: `
   <h4>Welcome</h4>
   <div><input type="text" name="username" /></div>
   <div><input type="password" name="password" /></div>
   <div><input (click)="authenticate()" type="button" value="Login" /></div>
  `,
  styles: [],
})
export class AuthenticationContainer {
  constructor(private router: Router) {}

  authenticate() {
    localStorage.setItem('loggedIn', 'true');
    this.router.navigate(['']);
  }
}
