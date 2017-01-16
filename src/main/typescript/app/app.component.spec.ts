/* tslint:disable:no-unused-variable */
import {TestBed, async, ComponentFixture} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {ClarityModule} from 'clarity-angular';
import {RouterTestingModule} from '@angular/router/testing';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {CoreModule} from './core/core.module';

describe('AppComponent', () => {

  let fixture: ComponentFixture<AppComponent>;
  let element: Element;
  let component: AppComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [
        CoreModule,
        FormsModule,
        ReactiveFormsModule,
        ClarityModule.forRoot(),
        RouterTestingModule
      ]
    });

    fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    element = fixture.nativeElement;
    component = fixture.componentInstance;
  });

  afterEach(() => {
    fixture.destroy();
  });

  it('should create the app', async(() => {
    expect(element).toBeTruthy();
  }));

});
