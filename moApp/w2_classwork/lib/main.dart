import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    Widget titleSection = Container(
      padding: const EdgeInsets.all(32),
      child: Row(
        children: [
          Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Container(
                    padding: const EdgeInsets.only(bottom: 8),
                    child: const Text(
                      'SHINWON LEE',
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                      ),
                    ),
                  ),
                  Text(
                      '22000539',
                      style: TextStyle(
                        color:  Colors.grey[500],
                      )
                  ),
                ],
              )
          ),
          const FavoriteWidget(),
        ],
      ),
    );

    Color color = Colors.black;

    Widget buttonSection = Container(
      padding: EdgeInsets.fromLTRB(10, 10, 10, 10),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          _buildButtonColumn(color, Icons.call, "CALL"),
          _buildButtonColumn(color, Icons.message, "MESSAGE"),
          _buildButtonColumn(color, Icons.email, "EMAIL"),
          _buildButtonColumn(color, Icons.share, "SHARE"),
          _buildButtonColumn(color, Icons.description, "ETC"),
        ],
      ),
    );

    Widget textSection = Container(
        padding: EdgeInsets.all(32.0),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Icon(Icons.message, size: 40.0,),
            Padding(
              padding: const EdgeInsets.fromLTRB(10, 0, 10, 0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    'Recent Message',
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  Text('Long time no see!')
                ],
              ),
            ),
          ],
        )
    );

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter w2_classwork',
      theme: ThemeData(scaffoldBackgroundColor: Colors.white),
      home: Scaffold(
        body: ListView(
          children: [
            Image.asset(
              'assets/image/me.jpg',
              height: 250,
              fit: BoxFit.fitHeight,
            ),
            titleSection,
            Divider(height: 1.0, color: Colors.black,),
            buttonSection,
            Divider(height: 1.0, color: Colors.black,),
            textSection,
          ],
        ),
      ),
    );
  }

  Column _buildButtonColumn(Color color, IconData icon, String label){
    return Column(
      mainAxisSize: MainAxisSize.min,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Icon(icon, color:color,),
        Container(
          margin: const EdgeInsets.only(top: 8),
          child: Text(
            label,
            style: TextStyle(
              fontSize: 12,
              fontWeight: FontWeight.w400,
              color: color,
            ),
          ),
        )
      ],
    );
  }
}


class FavoriteWidget extends StatefulWidget {
  const FavoriteWidget({Key? key}) : super(key: key);

  @override
  State<FavoriteWidget> createState() => _FavoriteWidgetState();
}

class _FavoriteWidgetState extends State<FavoriteWidget> {

  bool _isFavorited = true;
  int _favoriteCount = 41;

  void _toggleFavorite(){
    setState(() {
      if (_isFavorited){
        _favoriteCount -= 1;
        _isFavorited = false;
      }
      else{
        _favoriteCount += 1;
        _isFavorited =true;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisSize: MainAxisSize.min,
      children: [
        Container(
          padding: const EdgeInsets.all(0),
          child: IconButton(
            padding: const EdgeInsets.all(0),
            alignment: Alignment.centerRight,
            icon: (
                _isFavorited
                    ? const Icon(Icons.star)
                    : const Icon(Icons.star_border)),
            color: Colors.yellow[500],
            onPressed: _toggleFavorite,
          ),
        ),
        SizedBox(
          width: 20,
          child: SizedBox(
            child: Text('$_favoriteCount'),
          ),
        )
      ],
    );
  }
}
