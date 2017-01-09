import {uniqueActionType} from './unique-action-type';
import {async} from '@angular/core/testing';
describe('type', () => {

  it('should create type', async(() => {
    let object = uniqueActionType('test A');
    expect(object).toBeTruthy();
  }));

  it('should create distinct types', async(() => {
    let objectA = uniqueActionType('test 1');
    let objectB = uniqueActionType('test 2');
    let objectC = uniqueActionType('test 3');
    expect(objectA).toBeTruthy();
    expect(objectB).toBeTruthy();
    expect(objectC).toBeTruthy();
  }));

  it('should not create duplicated type', async(() => {
    let label = 'non unique';
    try {
      let objectA = uniqueActionType(label);
      let objectB = uniqueActionType(label);
      fail();
      expect(objectA).toBeTruthy();
      expect(objectB).toBeFalsy();
    } catch (err: Error) {
      expect(err.message).toBe(`Action type "${label}" is not unqiue`);
    }
  }));


});
