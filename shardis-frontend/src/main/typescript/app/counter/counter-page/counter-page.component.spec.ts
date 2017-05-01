/* tslint:disable:no-unused-variable */
import {ComponentFixture, TestBed, async} from '@angular/core/testing';
import {CoreModule} from '../../core/core.module';
import {CounterPageComponent} from './counter-page.component';
import {CounterComponent} from '../counter/counter.component';
import {BaseRequestOptions, Http, ConnectionBackend, RequestOptions} from '@angular/http';
import {MockBackend} from '@angular/http/testing';

describe('CounterPageComponent', () => {

  let fixture: ComponentFixture<CounterPageComponent>;
  let element: Element;
  let component: CounterPageComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        CounterPageComponent,
        CounterComponent
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

    fixture = TestBed.createComponent(CounterPageComponent);
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
