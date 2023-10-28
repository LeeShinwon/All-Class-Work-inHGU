import 'package:flutter/material.dart';
import 'package:midterm/viewController/home.dart';
import 'package:midterm/signup.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _usernameController = TextEditingController();
  final _passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
          child: ListView(
            padding: const EdgeInsets.symmetric(horizontal: 24.0),
            children: <Widget>[
              const SizedBox(height: 80.0,),
              Column(
                children: [
                  Image.asset('assets/img/diamond.png'),
                  const SizedBox(height:  16.0,),
                  const Text('SHRINE'),
                ],
              ),
              const SizedBox(height:  120.0,),
              TextField(
                controller: _usernameController,
                decoration: const InputDecoration(
                  filled: true,
                  labelText: 'Username',
                ),
              ),
              const SizedBox(height: 12.0,),
              TextField(
                controller: _passwordController,
                decoration: const InputDecoration(
                  filled: true,
                  labelText: 'Password',
                ),
                obscureText: true,
              ),
              const SizedBox(height: 12,),
              OverflowBar(
                alignment: MainAxisAlignment.spaceEvenly,
                children: [
                  TextButton(
                      onPressed: (){
                        _usernameController.clear();
                        _passwordController.clear();
                      },
                      child: const Text('CANCEL'),
                  ),
                  TextButton(
                    onPressed: (){
                      Navigator.push(context, MaterialPageRoute(builder: (context) => SignUpPage()));
                    },
                    child: const Text('Sign Up'),
                  ),
                  ElevatedButton(
                      onPressed: (){
                        Navigator.push(context, MaterialPageRoute(builder: (context) => HomePage()));
                      },
                      child: const Text('NEXT'),
                  ),
                ],
              )

            ],
          ),
      ),
    );
  }
}
