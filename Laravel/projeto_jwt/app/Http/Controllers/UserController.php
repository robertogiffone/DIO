<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;

class UserController extends Controller
{
    public function profile(Request $request)
    {
        User::where('id', auth()->user()->id)->update(
            [
                'name' => $request->input('name')
            ]
        );

        return response()->json([
            'message' => 'Usuário atualizado com sucesso'
        ]);
    }
}