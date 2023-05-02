import { ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable, Subscription } from 'rxjs';
import { AppState } from '../app.state';
import * as DemoActions from './../actions/demo.actions';

@Component({
  selector: 'app-component2',
  templateUrl: './component2.component.html',
  styleUrls: ['./component2.component.css'],
})
export class Component2Component implements OnInit {
  @ViewChild('nameUpdate') nameUpdate;
  @ViewChild('genderUpdate') genderUpdate;

  demoSubscription: Subscription;
  demo: Observable<any>;

  constructor(private store: Store<AppState>) {
    this.demo = store.select('demoStore');
  }

  addToStore(nameL: string, genderL: string) {
    this.store.dispatch(
      new DemoActions.AddDemo({
        name: nameL,
        gender: genderL,
      })
    );
  }

  updateToStore(nameL: string, genderL: string) {
    this.store.dispatch(
      new DemoActions.UpdateDemo({
        name: nameL,
        gender: genderL,
      })
    );
  }

  ngOnInit() {
    this.demoSubscription = this.demo.subscribe((res) => {
      const demoFound = res.demos[res.lastClicked];
      if (demoFound) {
        this.nameUpdate.nativeElement.value = demoFound.name;
        this.genderUpdate.nativeElement.value = demoFound.gender;
      }
    });
  }
}
