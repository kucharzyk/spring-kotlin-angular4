/* tslint:disable:no-unused-variable */
import {ComponentFixture, TestBed, async} from '@angular/core/testing';
import {CounterComponent} from './counter.component';
import {CoreModule} from '../../core/core.module';
import {BaseRequestOptions, Http, ConnectionBackend, RequestOptions} from '@angular/http';
import {MockBackend} from '@angular/http/testing';

describe('CounterComponent', () => {

  let fixture: ComponentFixture<CounterComponent>;
  let element: Element;
  let component: CounterComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        CounterComponent,
      ],
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
        }
      ]
    });

    fixture = TestBed.createComponent(CounterComponent);
    fixture.detectChanges();
    element = fixture.nativeElement;
    component = fixture.componentInstance;
  });

  afterEach(() => {
    fixture.destroy();
  });

  it('should create', async(() => {
    expect(element).toBeTruthy();
  }));
});
