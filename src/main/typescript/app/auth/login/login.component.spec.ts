/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {LoginComponent} from './login.component';
import {RouterTestingModule} from '@angular/router/testing';
import {CoreModule} from '../../core/core.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ClarityModule} from 'clarity-angular';
import {MockBackend} from '@angular/http/testing';
import {Http, ConnectionBackend, RequestOptions, BaseRequestOptions} from '@angular/http';

describe('LoginComponent', () => {
  let fixture: ComponentFixture<LoginComponent>;
  let element: Element;
  let component: LoginComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
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
        }
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    fixture.detectChanges();
    element = fixture.nativeElement;
    component = fixture.componentInstance;
  }));


  afterEach(() => {
    fixture.destroy();
  });


  it('should create', () =>  async(() => {
    expect(element).toBeTruthy();
  }));
});
