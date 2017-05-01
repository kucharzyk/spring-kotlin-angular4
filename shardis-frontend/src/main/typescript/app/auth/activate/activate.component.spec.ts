/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {ActivateComponent} from './activate.component';

describe('ActivateComponent', () => {
  let fixture: ComponentFixture<ActivateComponent>;
  let element: Element;
  let component: ActivateComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ActivateComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ActivateComponent);
    fixture.detectChanges();
    element = fixture.nativeElement;
    component = fixture.componentInstance;
  }));

  afterEach(() => {
    fixture.destroy();
  });


  it('should create',  async(() => {
    expect(element).toBeTruthy();
  }));
});
