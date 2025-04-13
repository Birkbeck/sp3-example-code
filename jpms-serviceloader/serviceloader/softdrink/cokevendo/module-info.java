module cokevendo {
  requires drinks;
  provides products.Drink with
    cokevendo.cococola.Coke,
    cokevendo.cococola.DietCoke;
}
