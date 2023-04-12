import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppContainer } from './containers/app/app.container';
import { EventsListContainer } from './containers/events-list/events-list.container';
import { EventDetailsContainer } from './containers/event-details/event-details.container';
import { EventService } from './services/event.service';

import { routing } from './routes';

@NgModule({
  imports:      [ BrowserModule, FormsModule, routing ],
  declarations: [ AppContainer, EventsListContainer, EventDetailsContainer ],
  providers:    [ EventService ],
  bootstrap:    [ AppContainer ]
})
export class AppModule { }
