/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {MainViewComponent} from './main-view.component';
import {RouterTestingModule} from '@angular/router/testing';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CoreModule} from '../../core/core.module';
import {CounterModule} from '../../counter/counter.module';
import {ClarityModule} from 'clarity-angular';
import {BaseRequestOptions, Http, RequestOptions, ConnectionBackend} from '@angular/http';
import {MockBackend} from '@angular/http/testing';

describe('MainViewComponent', () => {
  let fixture: ComponentFixture<MainViewComponent>;
  let element: Element;
  let component: MainViewComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [MainViewComponent],
      imports: [
        FormsModule,
        CoreModule,
        CounterModule,
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

    fixture = TestBed.createComponent(MainViewComponent);
    fixture.detectChanges();
    element = fixture.nativeElement;
    component = fixture.componentInstance;
  }));

  afterEach(() => {
    fixture.destroy();
  });


  it('should create', async(() => {
    expect(element).toBeTruthy();
  }));

  it(`should have as title 'shardis works!'`, async(() => {
    expect(component.title).toEqual('shardis works!');
  }));

  it('should render title in a h1 tag', async(() => {
    const h1 = element.querySelector('h1');
    expect(h1).toBeTruthy();
    if (!!h1) {
      expect(h1.textContent).toContain('shardis works!');
    }
  }));
});
