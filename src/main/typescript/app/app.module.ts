import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ClarityModule} from 'clarity-angular';
import {CoreModule} from './core/core.module';
import {MainModule} from './main/main.module';
import {Ng2Webstorage} from 'ng2-webstorage';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    ClarityModule.forRoot(),
    Ng2Webstorage.forRoot({prefix: 'shardis', separator: '.'}),
    AppRoutingModule,
    CoreModule,
    MainModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
