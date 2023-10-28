import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:flutter/material.dart';
import 'package:midterm/app.dart';
import 'package:provider/provider.dart';

import '../model/product.dart';
import '../model/products_repository.dart';


List<Product> products = ProductsRepository.loadProducts(Category.all);

class HomeDetailPage extends StatelessWidget {
  HomeDetailPage(this.index, {Key? key}) : super(key: key);
  int index;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Detail'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          FavoriteHotel(index),
          Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  children: [
                    for(int i=0; i<2; i++)
                      Icon(
                        Icons.star,
                        size: 20,
                        color: Colors.yellow,
                      ),
                  ],
                ),
                SizedBox(height: 10,),
                AnimatedName(products[index].name),
                // TextLiquidFill(
                //   text: products[index].name,
                //   boxBackgroundColor: Colors.red,
                //     waveColor: Colors.deepPurpleAccent,
                //     textStyle: TextStyle(
                //       fontSize: 20,
                //       fontWeight: FontWeight.bold,
                //     ),
                //   boxHeight: 50,
                // ),
                SizedBox(height: 10,),
                Row(
                  children: [
                    Icon(Icons.location_on),
                    SizedBox(width: 5,),
                    Container(
                      width: MediaQuery.of(context).size.width -69,
                      child: Text(products[index].location,
                      overflow: TextOverflow.fade,
                      maxLines: 3,
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 5,),
                Row(
                  children: [
                    Icon(Icons.phone,),
                    SizedBox(width: 5,),
                    Text(products[index].phone),
                  ],
                ),
                Divider(),
                Text(products[index].description),
              ],
            ),
          ),


        ],
      )
    );
  }
}

class FavoriteHotel extends StatelessWidget {
  FavoriteHotel(this.index, {Key? key}) : super(key: key);

  int index;

  @override
  Widget build(BuildContext context) {
    var appState = context.watch<MyFavoriteHotelState>();

    IconData icon;
    if (appState.favorites.contains(index)) {
      icon = Icons.favorite;
    } else {
      icon = Icons.favorite_border;
    }

    double width = MediaQuery.of(context).size.width;
    return Stack(
      children: [
        Hero(
          tag: 'image$index',
          child: Material(
            child: InkWell(
              child: Image.asset(
                products[index].assetName,
                fit: BoxFit.contain,
                width: width,
              ),
              onDoubleTap: (){//여기서의 index는 products all의 기준이기 때문에 값이라고 볼수 있다.
                appState.toggleFavorite(index);
              },
            ),
          ),
        ),
        Positioned(
            child: Icon(icon, color: Colors.red,),
          top: 16,
          right: 16,
        ),
        //Icon(Icons.favorite, color: Colors.red,),
      ],
    );
  }
}

class AnimatedName extends StatefulWidget {
  AnimatedName(this.name, {Key? key}) : super(key: key);

  String name;

  @override
  State<AnimatedName> createState() => _AnimatedNameState();
}

class _AnimatedNameState extends State<AnimatedName> {
  static const colorizeColors = [
    Colors.black,
    Colors.blue,
    Colors.deepPurpleAccent,
    Colors.orange,
    Colors.red,
  ];

  @override
  Widget build(BuildContext context) {
    return AnimatedTextKit(
        repeatForever: true,
        isRepeatingAnimation: true,
        animatedTexts: [
          ColorizeAnimatedText(
            widget.name,
            textStyle: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
            colors: colorizeColors,
          ),
        ],
    );

  }
}


