/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {AccessDeniedComponent} from './access-denied.component';

describe('AccessDeniedComponent', () => {
  let fixture: ComponentFixture<AccessDeniedComponent>;
  let element: Element;
  let component: AccessDeniedComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AccessDeniedComponent]
    })
      .compileComponents();
    fixture = TestBed.createComponent(AccessDeniedComponent);
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
