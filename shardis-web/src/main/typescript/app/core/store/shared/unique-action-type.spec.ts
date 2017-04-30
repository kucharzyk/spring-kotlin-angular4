import {uniqueActionType} from './unique-action-type';
import {async} from '@angular/core/testing';
describe('type', () => {

  it('should create type', async(() => {
    const object = uniqueActionType('test A');
    expect(object).toBeTruthy();
  }));

  it('should create distinct types', async(() => {
    const objectA = uniqueActionType('test 1');
    const objectB = uniqueActionType('test 2');
    const objectC = uniqueActionType('test 3');
    expect(objectA).toBeTruthy();
    expect(objectB).toBeTruthy();
    expect(objectC).toBeTruthy();
  }));

  it('should not create duplicated type', async(() => {
    const label = 'non unique';
    try {
      const objectA = uniqueActionType(label);
      const objectB = uniqueActionType(label);
      fail();
      expect(objectA).toBeTruthy();
      expect(objectB).toBeFalsy();
    } catch (err) {
      expect(err.message).toBe(`Action type "${label}" is not unqiue`);
    }
  }));


});
