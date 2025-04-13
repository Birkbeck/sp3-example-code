module pepsivendor {
  requires drinks;
  provides products.Drink with
    pepsicola.Pepsi,
    pepsicola.DietPepsi;
}
