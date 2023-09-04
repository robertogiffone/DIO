<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class BandController extends Controller
{
    public function getAll() {

        $bands = $this->getBands();

        return response()->json($bands);

    }

    public function getById($id) {

        $band = null;

        foreach($this->getBands() as $_band) {
            if ($_band['id'] == $id)
                $band = $_band;
        }

        return $band ? response()->json($band) : abort(404);

    }

    public function getBandsByGender($gender) {

        $bands = [];

        foreach($this->getBands() as $_band) {
            if (mb_strtolower($_band['gender']) == mb_strtolower($gender))
                $bands[] = $_band;
        }

        return response()->json($bands);

    }

    public function store(Request $request) {

        $validate = $request->validate([
            'id' => 'numeric',
            'name' => 'required|min:3'
        ]);

        return response()->json($request->all());

    }

    protected function getBands() {

        return [
            [
                'id' => 1, 'name' => 'Leandro Borges', 'gender' => 'Gospel'
            ],
            [
                'id' => 2, 'name' => 'Juliano Son', 'gender' => 'Gospel'
            ],
            [
                'id' => 3, 'name' => 'Leonardo Gonçalves', 'gender' => 'Gospel'
            ],
            [
                'id' => 4, 'name' => 'Roberto Carlos', 'gender' => 'MPB'
            ]
        ];

    }
}
