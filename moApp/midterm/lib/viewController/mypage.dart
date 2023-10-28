import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:provider/provider.dart';

import '../app.dart';
import '../model/product.dart';
import '../model/products_repository.dart';
import 'homeDetail.dart';

class MyPage extends StatefulWidget {
  const MyPage({Key? key}) : super(key: key);

  @override
  State<MyPage> createState() => _MyPageState();
}

class _MyPageState extends State<MyPage> with TickerProviderStateMixin{


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('My Page'),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16),
        child: Column(
          children: [
            Container(
              width: MediaQuery.of(context).size.width-32,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  SizedBox(height: 10,),
                  ClipOval(
                    child: Container(
                      width: 150,
                      height: 150,
                      color:Colors.deepPurpleAccent,
                      child: Lottie.asset(
                        'assets/lottie/animation_lnna7zds.json',
                      ),
                    ),
                  ),
                  SizedBox(height: 10,),
                  Text('Shinwon Lee',
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 20,
                  ),),
                  Text('22000539'),
                ],
              ),
            ),
            SizedBox(height: 30,),
            Container(
              width: MediaQuery.of(context).size.width-32,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('My Favorite Hotel List',
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 20,
                    ),
                  ),
                  MyFavoriteHotelsPage(),

                ],
              ),
            )

          ],
        ),
      ),
    );
  }
}

class MyFavoriteHotelsPage extends StatelessWidget {
  MyFavoriteHotelsPage({Key? key}) : super(key: key);

  List<Product> products = ProductsRepository.loadProducts(Category.all);

  @override
  Widget build(BuildContext context) {
    var width = MediaQuery.of(context).size.width;
    var height = MediaQuery.of(context).size.height;
    var appState = context.watch<MyFavoriteHotelState>();

    if (appState.favorites.isEmpty) {
      return Center(
        child: Text('No favorites yet.'),
      );
    }

    return Container(
      width: width,
      height: height - 393,
      child: ListView.builder(
        scrollDirection: Axis.vertical,
        itemBuilder: (BuildContext context, int index) {
          return Padding(
            padding: const EdgeInsets.only(top: 5),
            child: Card(
              child: Stack(
                children: [
                  ClipRRect(
                    borderRadius: BorderRadius.circular(8),
                    child: InkWell(
                      onTap: (){
                        Navigator.push(context, MaterialPageRoute(builder: (context) => HomeDetailPage(appState.favorites[index])));
                      },
                      child: Image.asset(
                        products[appState.favorites[index]].assetName,
                        width: width,
                        height: 200,
                        fit: BoxFit.fill,
                      ),
                    ),
                  ),
                  Positioned(
                    bottom: 16,
                    left: 16,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          products[appState.favorites[index]].name,
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 19,
                            color: Colors.white,
                          ),
                        ),
                        Container(
                          width: width - 50,
                          padding: EdgeInsets.only(right: 16),
                          child: Text(
                              products[appState.favorites[index]].location,
                            style: TextStyle(
                              fontWeight: FontWeight.normal,
                              fontSize: 12,
                              color: Colors.white,
                            ),
                            maxLines: 3,
                            overflow: TextOverflow.clip,
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          );
        },
        itemCount: appState.favorites.length,

      ),
    );
  }
}
