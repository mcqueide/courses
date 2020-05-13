import { Component, OnInit, OnDestroy } from '@angular/core';
import {interval, Observable, Subscription} from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {

  private firstObsSubscription: Subscription;
  
  constructor() { }

  ngOnInit() {
    //this.firstObsSubscription = interval(1000).subscribe(count => console.log(count));
    const customIntervalObserver = Observable.create(observer => {
      let count = 0;
      setInterval(() => observer.next(count++), 1000);
    });

    this.firstObsSubscription = customIntervalObserver.subscribe(data => console.log(data));
  }

  ngOnDestroy() {
    this.firstObsSubscription.unsubscribe();
  }

}
