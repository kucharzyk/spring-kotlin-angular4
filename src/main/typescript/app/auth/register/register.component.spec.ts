/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {RegisterComponent} from './register.component';

describe('RegisterComponent', () => {
  let fixture: ComponentFixture<RegisterComponent>;
  let element: Element;
  let component: RegisterComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(RegisterComponent);
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
});
