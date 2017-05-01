/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {ForgetPassComponent} from './forget-pass.component';

describe('ForgetPassComponent', () => {
  let fixture: ComponentFixture<ForgetPassComponent>;
  let element: Element;
  let component: ForgetPassComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ForgetPassComponent]
    })
      .compileComponents();
    fixture = TestBed.createComponent(ForgetPassComponent);
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
