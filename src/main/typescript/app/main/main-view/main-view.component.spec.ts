/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {MainViewComponent} from './main-view.component';
import {RouterTestingModule} from '@angular/router/testing';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CoreModule} from '../../core/core.module';
import {CounterModule} from '../../counter/counter.module';
import {ClarityModule} from 'clarity-angular';

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


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it(`should have as title 'shardis works!'`, async(() => {
    expect(component.title).toEqual('shardis works!');
  }));

  it('should render title in a h1 tag', async(() => {
    expect(element.querySelector('h1').textContent).toContain('shardis works!');
  }));
});
