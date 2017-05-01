import {browser, element, by} from 'protractor';

export class ShardisPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('shardis-root h1')).getText();
  }
}
