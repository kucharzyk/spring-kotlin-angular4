/* tslint:disable:no-unused-variable */
import {TestBed, async, ComponentFixture} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {ClarityModule} from 'clarity-angular';
import {RouterTestingModule} from '@angular/router/testing';


describe('AppComponent', () => {

  let fixture: ComponentFixture<AppComponent>;
  let element: Element;
  let component: AppComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
      ],
      imports: [
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

  it(`should have as title 'shardis works!'`, async(() => {
    expect(component.title).toEqual('shardis works!');
  }));

  it('should render title in a h1 tag', async(() => {
    expect(element.querySelector('h1').textContent).toContain('shardis works!');
  }));
});
