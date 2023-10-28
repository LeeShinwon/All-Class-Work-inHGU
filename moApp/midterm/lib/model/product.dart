enum Category{
  all,
  Asia,
  Erope,
  USA
}

class Product {
  const Product({
    required this.category,
    required this.id,
    required this.name,
    required this.location,
    required this.star,
    required this.phone,
    required this.description,
  });

  final Category category;
  final int id;
  final String name;
  final String location;
  final int star;
  final String phone;
  final String description;

  String get assetName => 'assets/img/hotel/h$id.png';
  //String get assetPackage => 'assets/img/hotel';

  // @override
  // String toString() => "$name (id=$id)";


}