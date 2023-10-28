import 'package:flutter/material.dart';
import 'package:midterm/login.dart';

class SignUpPage extends StatefulWidget {
  const SignUpPage({Key? key}) : super(key: key);

  @override
  State<SignUpPage> createState() => _SignUpPageState();
}

class _SignUpPageState extends State<SignUpPage> {
  final _formKey = GlobalKey<FormState>();

  final _usernameController = TextEditingController();
  final _passwordController = TextEditingController();
  final _confirmPasswordController = TextEditingController();
  final _emailAddressController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          padding: EdgeInsets.symmetric(horizontal: 24),
          child: Form(
            key: _formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.end,
              children: [
                CustomTextFormField('Username', _usernameController,false),
                const SizedBox(height: 12,),
                CustomTextFormField('Password', _passwordController,true),
                const SizedBox(height: 12,),
                CustomTextFormField('Confirm Password', _confirmPasswordController,true),
                const SizedBox(height: 12,),
                CustomTextFormField('Email Address', _emailAddressController,false),
                const SizedBox(height: 12,),
                ElevatedButton(
                    onPressed: (){
                      if(_formKey.currentState!.validate()){
                        Navigator.pushNamed(context, '/login');
                      }
                    },
                    child: Text('Sign Up')
                ),

              ],
            ),
            ),
        ),
      )
      ,
    );
  }

  Widget CustomTextFormField(String _labelText, TextEditingController _controller, bool _obsecureText){
    return TextFormField(
      decoration: InputDecoration(
        filled: true,
        labelText: _labelText,
      ),
      obscureText: _obsecureText,
      controller: _controller,
      validator: (value){
        if(value == null || value.isEmpty){
          return 'Please enter ' + _labelText;
        }
        else if(_labelText == 'Username'){
          if(value.replaceAll(RegExp('\\D'), "").length < 3 || value.replaceAll(RegExp('\\d'), "").length < 3){
            return 'Username is invalid';
          }
        }
        else if(_labelText == 'Confirm Password') {
          if (_passwordController.text != _confirmPasswordController.text) {
            return "confirm Password doesn't match Password";
          }
       }
        return null;
      },
    );
  }
}
