/* tslint:disable:no-unused-variable */
import {TestBed, inject} from '@angular/core/testing';
import {AuthService} from './auth.service';
import {Http, BaseRequestOptions, ConnectionBackend, RequestOptions} from '@angular/http';
import {MockBackend} from '@angular/http/testing';
import {CoreModule} from '../../core.module';

describe('Service: Auth', () => {

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        CoreModule
      ],
      providers: [
        BaseRequestOptions,
        MockBackend,
        {
          provide: Http,
          useFactory: function (backend: ConnectionBackend, defaultOptions: RequestOptions) {
            return new Http(backend, defaultOptions);
          },
          deps: [MockBackend, BaseRequestOptions]
        },
        AuthService
      ]
    });
  });

  it('should exist', inject([AuthService], (service: AuthService) => {
    expect(service).toBeTruthy();
  }));


});
