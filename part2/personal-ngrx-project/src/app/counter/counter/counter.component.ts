import {Component} from '@angular/core';
import {Store} from "@ngrx/store";
import {decrement, increment, reset} from "../counter.actions";
import {selectCounter} from "../counter.selectors";

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent {

  counter$ = this.store.select(selectCounter);

  constructor(private store: Store) {
  }

  increment() {
    this.store.dispatch(increment());
  }

  decrement() {
    this.store.dispatch(decrement());
  }

  reset() {
    this.store.dispatch(reset());
  }


}
