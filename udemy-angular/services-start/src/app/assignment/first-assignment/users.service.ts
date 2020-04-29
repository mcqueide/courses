import {EventEmitter, Injectable} from '@angular/core';
import {CounterService} from './counter.service';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  activeUsers = ['Max', 'Anna'];
  inactiveUsers = ['Chris', 'Manu'];
  userSetToInactive = new EventEmitter<number>();
  userSetToActive = new EventEmitter<number>();

  constructor(private counterService: CounterService) {
    this.userSetToInactive.subscribe((id) => this.setToInactive(id));
    this.userSetToActive.subscribe((id) => this.setToActive(id));
  }

  setToInactive(id: number) {
    this.inactiveUsers.push(this.activeUsers[id]);
    this.activeUsers.splice(id, 1);
    this.counterService.changeActiveToInactive();
  }

  setToActive(id: number) {
    this.activeUsers.push(this.inactiveUsers[id]);
    this.inactiveUsers.splice(id, 1);
    this.counterService.changeInactiveToActive();
  }
}
