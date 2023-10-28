import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../app.dart';
import '../model/product.dart';
import '../model/products_repository.dart';

class FavoriteHotelPage extends StatefulWidget {
  const FavoriteHotelPage({Key? key}) : super(key: key);

  @override
  State<FavoriteHotelPage> createState() => _FavoriteHotelPageState();
}

class _FavoriteHotelPageState extends State<FavoriteHotelPage> {
  List<Product> products = ProductsRepository.loadProducts(Category.all);


  @override
  Widget build(BuildContext context) {
    var appState = context.watch<MyFavoriteHotelState>();

    return Scaffold(
      appBar: AppBar(
        title: Text('Favorite Hotels'),
      ),
      body: ListView.builder(
        itemBuilder: (BuildContext context, int index) {
          final item = products[appState.favorites[index]].name;
          return Dismissible(
              key: UniqueKey(),
            onDismissed: (direction) {
              // Remove the item from the data source.
              setState(() {
                appState.removeFavorite(index);
              });
              },
            child: ListTile(
              title: Text(item),
            ),
          );
        },
        itemCount: appState.favorites.length,

      ),
    );
  }
}
