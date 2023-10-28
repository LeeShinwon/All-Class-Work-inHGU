import 'package:flutter/material.dart';
import 'package:midterm/viewController/favoriteHotel.dart';
import 'package:midterm/model/product.dart';
import 'package:midterm/model/products_repository.dart';
import 'package:midterm/viewController/mypage.dart';
import 'package:midterm/viewController/search.dart';
import 'package:midterm/signup.dart';
import 'package:url_launcher/url_launcher.dart';

import 'homeDetail.dart';


class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Main'),
        actions: [
          IconButton(
              onPressed: (){
                Navigator.pushNamed(context, '/search');
              },
              icon: const Icon(
                Icons.search,
                semanticLabel: 'search',
              ),
          ),
          IconButton(
            onPressed: (){
              launchUrl(
                Uri.parse('https://www.handong.edu/'),
              );
            },
            icon: const Icon(
              Icons.language,
              semanticLabel: 'language',
            ),
          ),
        ],
      ),
      drawer: const DrawerWidget(),
      body: ToggleButtonWidget(),

      resizeToAvoidBottomInset: false,
    );
  }
}


class DrawerWidget extends StatefulWidget {
  const DrawerWidget({Key? key}) : super(key: key);

  @override
  State<DrawerWidget> createState() => _DrawerWidgetState();
}

class _DrawerWidgetState extends State<DrawerWidget> {
  int _selectedIndex = 0;

  void _onItemTapped(int index){
    setState(() {
      _selectedIndex = index;
    });
  }
  
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          DrawerHeader(
              child: Container(
                margin: EdgeInsets.all(20),
                alignment: Alignment.bottomLeft,
                child: Text('Pages',
                style: TextStyle(
                  fontSize: 30,
                  color: Colors.white,
                ),),
              ),
            decoration: BoxDecoration(
              color: Colors.deepPurpleAccent,
            ),
          ),
          Column(
            children: [
              drawerListTitle(Icon(Icons.home),'Home',0, '/'),
              drawerListTitle(Icon(Icons.search),'Search',1, '/search'),
              drawerListTitle(Icon(Icons.location_city),'Favorite Hotels',2, '/favorite'),
              drawerListTitle(Icon(Icons.person),'My Page',3, '/myPage'),
              drawerListTitle(Icon(Icons.logout),'Logout',4, '/login'),
            ],
          )


        ],
      ),
    );
  }
  Widget drawerListTitle(_icon, _title, _index, _name){
    return ListTile(
      leading: _icon,
      title: Text(_title),
      selected: _selectedIndex == _index,
      onTap: (){
        _onItemTapped(_index);
        Navigator.pop(context);
        Navigator.pushNamed(context, _name);
      },
    );
  }
}


class ToggleButtonWidget extends StatefulWidget {
  const ToggleButtonWidget({Key? key}) : super(key: key);

  @override
  State<ToggleButtonWidget> createState() => _ToggleButtonWidgetState();
}

class _ToggleButtonWidgetState extends State<ToggleButtonWidget> {
  List<Product> products = ProductsRepository.loadProducts(Category.all);


  final List<bool> _selected = [false, true];

  List<Widget> icons = [
    const Icon(Icons.list),
    const Icon(Icons.grid_view),
  ];


  @override
  Widget build(BuildContext context) {

    return Column(
      crossAxisAlignment: CrossAxisAlignment.end,
      children: [
        Padding(
          padding: const EdgeInsets.fromLTRB(16, 4, 16, 0),
          child: ToggleButtons(
            constraints: BoxConstraints(maxWidth: 40, minWidth: 40, minHeight: 40, maxHeight: 40),
              children: icons,
              isSelected: _selected,
            onPressed: (int index){
                setState(() {
                  for(int i=0; i<_selected.length; i++){
                    _selected[i] = i == index;
                  }
                });
            },
            borderRadius: BorderRadius.all(Radius.circular(8)),
            selectedBorderColor: Colors.blue[700],
            selectedColor: Colors.blue,
            fillColor: Colors.blue[200],
            color:Colors.grey,

          ),
        ),
        _selected[1]?
        Expanded(
          child: OrientationBuilder(
              builder: (context, orientation) {
                return Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: GridView.builder(
                      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                        crossAxisCount: orientation == Orientation.portrait ? 2 : 3, //1 개의 행에 보여줄 item 개수
                        childAspectRatio: orientation == Orientation.portrait ? 1 / 1.4 : 1 / 1.1, //item 의 가로 1, 세로 2 의 비율
                        mainAxisSpacing: 10, //수평 Padding
                        crossAxisSpacing: 10, //수직 Padding
                      ),
                      itemCount: products.length,
                      itemBuilder: (BuildContext context, int index){
                        return Card(
                          clipBehavior: Clip.antiAlias,
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.start,
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              AspectRatio(
                                aspectRatio: 18/11,
                                child: Hero(
                                  tag: 'image$index',
                                  child: Image.asset(
                                    products[index].assetName,
                                    fit: BoxFit.fitWidth,
                                    //package: product.assetPackage,
                                  ),
                                ),
                              ),
                              Expanded(
                                child: Padding(
                                  padding: EdgeInsets.fromLTRB(8, 4, 8, 0),
                                  child: Row(
                                    children: [
                                      Icon(Icons.location_on, color: Colors.deepPurpleAccent),
                                      Column(
                                        crossAxisAlignment: CrossAxisAlignment.start,
                                        children: [
                                          Row(
                                            children: [
                                              for(int i=0; i<products[index].star; i++)
                                                Icon(
                                                  Icons.star,
                                                  size: 20,
                                                  color: Colors.yellow,
                                                ),
                                            ],
                                          ),

                                          Padding(
                                            padding: const EdgeInsets.only(left: 8),
                                            child: Container(
                                              width: MediaQuery.of(context).size.width/2 - ( orientation == Orientation.portrait ? 70 : 210),
                                              child: Column(
                                                crossAxisAlignment: CrossAxisAlignment.start,
                                                children: [
                                                  Text(
                                                    products[index].name,
                                                    style: TextStyle(
                                                      fontWeight: FontWeight.bold,
                                                      fontSize: 15,
                                                    ),
                                                    overflow: TextOverflow.clip,
                                                    maxLines: 1,
                                                  ),
                                                  Text(
                                                    products[index].location,
                                                    style: TextStyle(
                                                      fontWeight: FontWeight.normal,
                                                      fontSize: 12,
                                                    ),
                                                    overflow: TextOverflow.clip,
                                                    maxLines: 2,
                                                  ),
                                                  Container(
                                                    alignment: Alignment.bottomRight,
                                                    child: TextButton(
                                                        onPressed: (){
                                                          Navigator.of(context).push(MaterialPageRoute<void>(
                                                              builder: (BuildContext context) {
                                                                return HomeDetailPage(index);
                                                              }
                                                          ));
                                                         },
                                                        child: Text('more',)
                                                    ),
                                                  )
                                                ],
                                              ),
                                            ),
                                          ),

                                        ],
                                      ),
                                    ],
                                  ),
                                ),
                              )
                            ],
                          ),
                        );
                      },

                  ),
                );
              }
          ),
        ):
            Expanded(
                child: ListView.builder(
                  itemCount: products.length,
                    itemBuilder: (context, index){
                      return Padding(
                        padding: const EdgeInsets.fromLTRB(8, 4, 8, 0),
                        child: Card(
                          child: Padding(
                            padding: const EdgeInsets.all(12.0),
                            child: Row(
                              children: [
                                ClipRRect(
                                  borderRadius: BorderRadius.circular(8),
                                  child: Hero(
                                    tag: 'image$index',
                                    child: Image.asset(
                                      products[index].assetName,
                                      fit: BoxFit.fill,
                                      width: 100,
                                      height: 100,
                                      //package: product.assetPackage,
                                    ),
                                  ),
                                ),
                                Expanded(
                                  child: Padding(
                                    padding: const EdgeInsets.all(8.0),
                                    child: Column(
                                      crossAxisAlignment: CrossAxisAlignment.start,
                                      children: [
                                        Row(
                                          children: [
                                            for(int i=0; i<products[index].star; i++)
                                              Icon(
                                                Icons.star,
                                                size: 20,
                                                color: Colors.yellow,
                                              ),
                                          ],
                                        ),
                                        Text(products[index].name,
                                        style: TextStyle(
                                          fontWeight: FontWeight.bold,
                                          fontSize: 15,
                                        ),),
                                        SizedBox(height: 5,),
                                        Text(products[index].location,
                                          style: TextStyle(
                                            fontWeight: FontWeight.normal,
                                            fontSize: 12,
                                          ),
                                          //overflow: TextOverflow.clip,
                                          maxLines: 2,
                                        ),
                                      ],
                                    ),
                                  ),
                                ),
                                Container(
                                  height:100,
                                  alignment: Alignment.bottomLeft,
                                  child: TextButton(
                                    onPressed: (){
                                      Navigator.of(context).push(MaterialPageRoute<void>(
                                          builder: (BuildContext context) {
                                            return HomeDetailPage(index);
                                            //products[index].star, products[index].name, products[index].location,
                                          }
                                      ));
                                    },
                                    child: Text("more"),
                                    style: TextButton.styleFrom(
                                      minimumSize: Size.zero,
                                      padding: EdgeInsets.zero,
                                      tapTargetSize: MaterialTapTargetSize.shrinkWrap,
                                    ),
                                  ),
                                ),

                              ],
                            ),
                          ),
                        ),
                      );
                    }
                )
            ),

      ],
    );
  }
}


