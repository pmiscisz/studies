<?php
namespace App\Http\Controllers;

use App\Models\User;
use Auth;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Validator;

class AuthController extends Controller
{public function register(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'name'     => 'required|string|max:255',
            'email'    => 'required|string|email|max:255|', //'required|string|email|max:255|unique:users'
            'password' => 'required|string|min:8',
        ]);
    
        if ($validator->fails()) {
            return response()->json($validator->errors(), 422);
        }
    
        
        if (User::where('email', $request->email)->exists()) {
            return response()->json(['error' => 'Użytkownik o tym e-mailu już istnieje.'], 409);
        }
    
        $user = User::create([
            'name'     => $request->name,
            'email'    => $request->email,
            'password' => Hash::make($request->password),
        ]);
    
        $token = $user->createToken('auth_token')->plainTextToken;
    
        return response()->json([
            'data'        => $user,
            'access_token' => $token,
            'token_type'  => 'Bearer',
        ], 201);
    }
    
    public function login(Request $request) //logowanie
    {
        if (! Auth::attempt($request->only('email', 'password'))) {
            return response()
                ->json(['message' => 'Zły login lub hasło!'], 401);
        }
        $user  = User::where('email', $request['email'])->firstOrFail();
        $token = $user->createToken('auth_token')->plainTextToken;
        return response()
            ->json(['message' => 'Hi ' . $user->name,
                'access_token'    => $token, 'token_type' => 'Bearer']);
    }
    // wylogowanie i usunięcie tokena
    public function logout(Request $request)
    {
        auth()->user()->tokens()->delete(); //usunięcie tokena
        $request->session()->flush();       //usunięcie danych sesji
        return [
            'message' => 'Logged out',
        ];
    }}
