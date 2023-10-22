<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});*/

Route::get('/', function () {
    return response()->json(
        [
            'version' => app()->version(),
        ]
    );
});

Route::group(
    [
        'prefix' => 'auth'
    ], 
    function () {
        Route::post('login', 'AuthController@login');
        Route::post('logout', 'AuthController@logout');
        Route::post('refresh', 'AuthController@refresh');
        Route::post('me', 'AuthController@me');
        Route::post('register', 'AuthController@register');
    }
);

Route::group(
    [
        'middleware' => 'auth:api'
    ],
    function () {
        Route::patch('user/profile', 'UserController@profile');
    }
);