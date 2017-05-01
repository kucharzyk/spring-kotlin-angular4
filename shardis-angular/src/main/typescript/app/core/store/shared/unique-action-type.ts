/**
 * This function coerces a string into a string literal type.
 * Using tagged union types in TypeScript 2.0, this enables
 * powerful typechecking of our reducers.
 *
 * Since every action label passes through this function it
 * is a good place to ensure all of our action labels
 * are unique.
 */

const uniqueActionTypeCache: {[label: string]: boolean} = {};

export function uniqueActionType<T>(label: T | ''): T {
  if (uniqueActionTypeCache[<string>label]) {
    throw new Error(`Action type "${label}" is not unqiue`);
  }

  uniqueActionTypeCache[<string>label] = true;

  return <T>label;
}
