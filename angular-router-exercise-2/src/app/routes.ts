import { RouterModule } from '@angular/router';
import { EventDetailsContainer } from './containers/event-details/event-details.container';
import { EventsListContainer } from './containers/events-list/events-list.container';

export const routes = [
  { path: '', component: EventsListContainer },
  { path: 'events/:id', component: EventDetailsContainer },
];
export const routing = RouterModule.forRoot(routes);
