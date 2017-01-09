/* tslint:disable:no-unused-variable */
import {ComponentFixture, TestBed} from '@angular/core/testing';
import {CounterComponent} from './counter.component';
import {CoreModule} from '../../core/core.module';

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

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
