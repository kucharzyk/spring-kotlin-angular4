/* tslint:disable:no-unused-variable */
import {ComponentFixture, TestBed, async} from '@angular/core/testing';
import {CoreModule} from '../../core/core.module';
import {CounterPageComponent} from './counter-page.component';
import {CounterComponent} from '../counter/counter.component';

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
