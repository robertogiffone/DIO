<?php

namespace App\Http\Controllers;

use App\Http\Requests\Endereco\SalvarRequest;
use App\Models\Endereco;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class EnderecoController extends Controller
{
    public function index()
    {
        $enderecos = Endereco::all();
        return view('listagem')->with(
            [
                'enderecos' => $enderecos
            ]
        );
    }

    public function adicionar()
    {
        return view('busca');
    } 

    public function buscar(Request $request)
    {
        $cep = $request->input('cep');

        $url = 'https://viacep.com.br/ws/'.$cep.'/json/';

        $response = Http::get($url)->json();

        return view('adicionar')->with(
            [
                'cep' => $cep,
                'logradouro' => $response['logradouro'],
                'bairro' => $response['bairro'],
                'cidade' => $response['localidade'],
                'estado' =>  $response['uf'],
            ]
        );
    }

    public function salvar(SalvarRequest $request)
    {
        $endereco = Endereco::where('cep', $request->input('cep'))->first();
        
        if (!$endereco) {
            Endereco::create(
                [
                    'cep' => $request->input('cep'),
                    'logradouro' => $request->input('logradouro'),
                    'numero' => $request->input('numero'),
                    'bairro' => $request->input('bairro'),
                    'cidade' => $request->input('cidade'),
                    'estado' => $request->input('estado'),
                ]
            );

            return redirect('/')->withSucesso('Endereço salvo com sucesso');
        }
    
        return redirect('/')->withErro('Endereço já cadastrado');
    }
}