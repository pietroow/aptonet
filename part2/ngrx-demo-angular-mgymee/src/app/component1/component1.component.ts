import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import * as DemoActions from './../actions/demo.actions';

@Component({
  selector: 'app-component1',
  templateUrl: './component1.component.html',
  styleUrls: ['./component1.component.css'],
})
export class Component1Component implements OnInit {
  demo: Observable<any>;

  constructor(private store: Store<AppState>) {
    this.demo = store.select('demoStore');
  }

  selectedDemo(index: number) {
    this.store.dispatch(new DemoActions.LastSelected(index));
  }

  ngOnInit() {}
}
