<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HelloWorldController extends Controller
{
    public function hello($name, Request $request)
    {
        //return 'hello post '.$name;
        return response()->json([
            'name' => 'hello '.$name,
            'foo' => $request->foo
        ]);
    }
}
