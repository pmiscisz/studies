<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Product;

class ProductController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $products = Product::all();
        return $products;
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $product = new Product();
        if (!$request->input('name') || $request->input('name') === "") {
            return response()->json(['error' => "Nazwa produktu nie może być pusta"], 400);
        }

        if ((!$request->has('price')) || !is_numeric($request->input('price')) || $request->input('price') <= 0) {
            return response()->json(['error' => "Cena musi być liczbą większą od zera"], 400);
        }
        $product->name = $request->input('name');
        $product->price = $request->input('price');
        $product->save();
        return response()->json($product);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $product = Product::findOrFail($id);
        if (!$product) {
            return response()->json(['error' => 'Produkt nie znaleziony.'], 404);
        }
        return response()->json($product);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $product = Product::findOrFail($id);
        if (!$request->input('name') || $request->input('name') === "") {
            return response()->json(['error' => "Nazwa produktu nie może być pusta"], 400);
        }

        if ((!$request->has('price')) || !is_numeric($request->input('price')) || $request->input('price') <= 0) {
            return response()->json(['error' => "Cena musi być liczbą większą od zera"], 400);
        }

        $product->name = $request->input('name');
        $product->price = $request->input('price');
        $product->save();
        return response()->json($product);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $product = Product::findOrFail($id);
        if($product->delete())
            return response()->json($product);
    }
}