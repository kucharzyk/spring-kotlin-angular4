import {ShardisPage} from './app.po';

describe('shardis App', function () {
  let page: ShardisPage;

  beforeEach(() => {
    page = new ShardisPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toMatch('shardis works!');
  });
});
