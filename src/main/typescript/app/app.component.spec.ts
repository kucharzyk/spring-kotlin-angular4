/* tslint:disable:no-unused-variable */
import {TestBed, async, ComponentFixture} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {ClarityModule} from 'clarity-angular';
import {RouterTestingModule} from '@angular/router/testing';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {CoreModule} from './core/core.module';
import {BaseRequestOptions, Http, ConnectionBackend, RequestOptions} from '@angular/http';
import {MockBackend} from '@angular/http/testing';
import {AuthService} from './core/store/auth/auth.service';

describe('AppComponent', () => {

  let fixture: ComponentFixture<AppComponent>;
  let element: Element;
  let component: AppComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [
        CoreModule,
        FormsModule,
        ReactiveFormsModule,
        ClarityModule.forRoot(),
        RouterTestingModule
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

    fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    element = fixture.nativeElement;
    component = fixture.componentInstance;
  });

  afterEach(() => {
    fixture.destroy();
  });

  it('should create the app', async(() => {
    expect(element).toBeTruthy();
  }));

});
