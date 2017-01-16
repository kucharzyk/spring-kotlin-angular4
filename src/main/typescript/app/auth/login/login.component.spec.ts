/* tslint:disable:no-unused-variable */
import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {LoginComponent} from './login.component';
import {RouterTestingModule} from '@angular/router/testing';
import {CoreModule} from '../../core/core.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ClarityModule} from 'clarity-angular';

describe('LoginComponent', () => {
  let fixture: ComponentFixture<LoginComponent>;
  let element: Element;
  let component: LoginComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      imports: [
        CoreModule,
        FormsModule,
        ReactiveFormsModule,
        ClarityModule.forRoot(),
        RouterTestingModule
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
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
