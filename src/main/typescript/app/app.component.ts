import {Component, OnInit} from '@angular/core';
import {AuthService} from './core/store/auth/auth.service';

@Component({
  selector: 'shardis-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.authService.dispatchToken();
  }

}
