import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'shardis-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.scss']
})
export class CounterComponent implements OnInit {

  @Input() value: number;
  @Output() increment = new EventEmitter();
  @Output() decrement = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

}
