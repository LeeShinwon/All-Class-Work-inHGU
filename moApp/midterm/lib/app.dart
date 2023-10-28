import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:midterm/signup.dart';
import 'package:midterm/viewController/favoriteHotel.dart';
import 'package:midterm/viewController/mypage.dart';
import 'package:midterm/viewController/search.dart';
import 'package:provider/provider.dart';
import 'viewController/home.dart';
import 'login.dart';

class ShrineApp extends StatelessWidget {
  const ShrineApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(
          create: (BuildContext context) => MyFavoriteHotelState(),
        ),
        ChangeNotifierProvider(
          create: (BuildContext context) => SearchState(),
        ),
      ],
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Shrine',
        initialRoute: '/login',
        routes: {
          '/': (BuildContext context) => const HomePage(),
          '/login': (BuildContext context) => const LoginPage(),
          '/search': (BuildContext context) => const SearchPage(),
          '/favorite': (BuildContext context) => const FavoriteHotelPage(),
          '/myPage': (BuildContext context) => const MyPage(),
          '/signUp':(BuildContext context) => const SignUpPage(),
        },
        theme: ThemeData(useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(
            seedColor: Colors.deepPurpleAccent,
            brightness: Brightness.light,
          ),
        ),
      ),
    );
  }
}

class MyFavoriteHotelState extends ChangeNotifier {
  var favorites = [];

  void toggleFavorite([int? index]) {
    if (favorites.contains(index)) {
      favorites.remove(index);
    } else {
      favorites.add(index);
    }
    notifyListeners();
  }

  void removeFavorite([int? index]){
    favorites.removeAt(index!);
    notifyListeners();
  }
}

class SearchState extends ChangeNotifier {
  var dateTime = DateTime.now();
  var checkedFilter = [false,false,false];


  String getCheckedList(){
    var checkboxList = ['No Kids Zone','Pet-friendly','Free breakfast'];
    String checked ='';
    for(int i=0; i<checkedFilter.length; i++){
      if(checkedFilter[i]){
        checked += checkboxList[i]+' / ';
      }
    }
    if(checked == ''){
      checked += "There is no selected filter.";
    }
    return checked;
  }
}