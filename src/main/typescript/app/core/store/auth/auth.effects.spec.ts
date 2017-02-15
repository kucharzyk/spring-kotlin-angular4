/* tslint:disable:no-unused-variable */
import {TestBed, inject} from '@angular/core/testing';
import {Http, BaseRequestOptions, ConnectionBackend, RequestOptions} from '@angular/http';
import {MockBackend} from '@angular/http/testing';
import {CoreModule} from '../../core.module';
import {AuthEffects} from './auth.effects';

describe('Effects: Auth', () => {

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
        AuthEffects
      ]
    });
  });

  it('should exist', inject([AuthEffects], (service: AuthEffects) => {
    expect(service).toBeTruthy();
  }));


});
